const API_URL = 'http://localhost:3000/api/'; // URL do back-end
const productsContainer = document.getElementById('products-container');
const cartContainer = document.getElementById('cart-container');
const orderContainer = document.getElementById('order-container');
const cart = [];
const orders = [];
const produtosTotal = []

document.addEventListener('DOMContentLoaded', () => {
    // Função para buscar produtos da API
    async function fetchProducts() {
        try {
            const response = await fetch(API_URL + 'produtos');
            if (!response.ok) {
                throw new Error('Erro ao buscar produtos');
            }

            const message = await response.json();
            if (message.error) {
                throw new Error(message.error);
            }
            const produtos = message.data.produtos;
            produtosTotal.push(...produtos)
            console.log(produtos)
            renderProducts(produtos);
        } catch (error) {
            console.error(error);
            productsContainer.innerHTML = '<p>Erro ao carregar os produtos.</p>';
        }
    }

    // Função para renderizar os produtos como cards
    function renderProducts(produtos) {
        productsContainer.innerHTML = ''; // Limpa o conteúdo anterior

        produtos.forEach((produto) => {
            const card = `
            <div class="card">
                <h2>${produto.nome}</h2>
                <p><strong>R$ ${produto.valor.toFixed(2)}</strong></p>
                <button data="${produto.id}" onclick="addCart(this)">Adicionar ao carrinho</button>
            </div> 
            `;
            productsContainer.insertAdjacentHTML('beforeend', card);
        });
    }

    // Carregar os produtos assim que a página abrir
    fetchProducts();
});

// função para adicionar produtos ao carrinho deve receber id do produto
async function addCart(cardComponent) {
    try {
        const id = cardComponent.getAttribute('data');

        const response = await fetch(API_URL + 'produto/' + id);
        if (!response.ok) {
            throw new Error(response.status);
        }
        const message = await response.json();
        if (message.error) {
            throw new Error(message.error);
        }
        const produto = message.data;

        const productCart = cart.find((item) => item.id === produto.id);

        if (productCart) {
            if (productCart.quantidade >= produto.quantidade) {
                alert('Produto fora de estoque');
                return;
            }
            productCart.quantidade += 1;
            updateCartItem(productCart);
        } else {
            if (produto.quantidade === 0)
                return;
            const produtoCarrinho = {
                id: produto.id,
                nome: produto.nome,
                valor: produto.valor,
                quantidade: 1,
            };
            cart.push(produtoCarrinho);
            renderProductCart(produtoCarrinho);
        }
    } catch (error) {
        console.error(error);
        if (error.message === '404') {
            alert('Não há produto no estoque');
            return;
        }
        alert('Erro ao adicionar produto ao carrinho');
    }
}

function renderProductCart(produto) {

    // Cria o HTML do card com o contador
    const card = `
      <div class="card cart" id="cart-item-${produto.id}">

        <h2>${produto.nome}</h2>
        <p><strong>R$ ${produto.valor.toFixed(2)}</strong></p>
        
        <label>Quantidade:</label> 
        <div>
            <button data="${produto.id}"  onclick="removeCartItem(this)">-</button>
            <span id="quantity-${produto.id}">${produto.quantidade}</span>
            <button data="${produto.id}" onclick="addCart(this)">+</button>
        </div>
      </div>
    `;
    cartContainer.insertAdjacentHTML('beforeend', card);
}


function updateCartItem(produto) {
    // Atualiza apenas o contador de quantidade no HTML
    const quantityElement = document.getElementById(`quantity-${produto.id}`);

    if (quantityElement) {
        quantityElement.textContent = produto.quantidade;
    }
}
function removeCartItem(cardComponent) {
    // Remove um item do carrinho
    const id = cardComponent.getAttribute('data');
    const productCart = cart.find((item) => item.id === id);

    if (productCart.quantity > 1) {
        productCart.quantity -= 1;
        updateCartItem(productCart);
    } else {
        const cartItem = document.getElementById(`cart-item-${id}`);
        cartItem.remove();
        cart.splice(cart.indexOf(productCart), 1);
    }
    // Tem que enviar um fetch
}

async function makeOrder() {
    try {
        const pedido = {
            produtoId: cart[0].id,
            quantidade: cart[0].quantidade,
            nomeComprador: 'Fulano',
        }


        const response = await fetch(API_URL + 'pedido', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(pedido),
        });


        if (!response.ok) {
            throw new Error(response);
        }
        const message = await response.json();
        cartContainer.innerHTML = ''; // Limpa o carrinho
        // Limpa o objeto cart
        cart.length = 0;
        const pedidoRetornado = message.data;
        console.log(pedidoRetornado)
        orders.push(pedidoRetornado);
        renderCardOrder(pedidoRetornado);
    } catch (error) {
        console.error(error);
        alert('Erro ao fazer pedido');
    }
}

function renderCardOrder(pedidoRetornado) {
    // Cria o HTML do card do pedido
    console.log(pedidoRetornado)

    const produto = produtosTotal.find((item) => item.id === pedidoRetornado.produtoId);
    const precoTotal = produto.valor * pedidoRetornado.quantidade;
    const card = `
      <div class="card order" id="order-item-${pedidoRetornado.id}">
        <h2>Pedido ${pedidoRetornado.id}</h2>
        <p>Produto: ${produto.nome}</p>
        <p>Quantidade: ${pedidoRetornado.quantidade}</p>
        <p>Preço total: R$ ${precoTotal.toFixed(2)}</p>
        <p>Status: ${pedidoRetornado.status}</p>
        </div>
    `;
    orderContainer.insertAdjacentHTML('beforeend', card);
}


async function atualizarCardsOrders() {

    try {
        const response = fetch(API_URL + 'pedidos');

        if (!response.ok) {
            throw new Error(response);
        }
        const message = await response.json();

        if (message.error) {
            throw new Error(message.error);
        }
        const pedidos = message.data.pedidos;
        orders.push(...pedidos);
        renderOrders(orders);
    } catch (error) {
        console.error(error);
        alert('Erro ao buscar pedidos');
    }
}

function renderOrders(pedidos) {
    orderContainer.innerHTML = ''; // Limpa o conteúdo anterior

    pedidos.forEach((pedido) => {
        renderCardOrder(pedido);
    });
}

const eventSource = new EventSource('http://localhost:3005/stream-sse');

// Evento disparado quando uma mensagem é recebida
eventSource.onmessage = (event) => {
    console.log('Mensagem padrão recebida:', event.data);
};

eventSource.addEventListener('custom-event', (event) => {
    const data = JSON.parse(event.data);
    console.log('Evento customizado recebido:', data);
});

// Evento disparado quando ocorre um erro
eventSource.onerror = (error) => {
    console.error('Erro na conexão SSE:', error);
    console.log('Erro na conexão com o servidor.');
};

// Evento quando a conexão é aberta
eventSource.onopen = () => {
    console.log('Conexão SSE estabelecida');
    console.log('Conexão estabelecida com o servidor.');
};

function postEvent() {
    const body = {
        text: 'teste',
    };
    fetch('http://localhost:3005/send-event', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body),
    })
        .then((response) => {
            if (response.ok) {
                console.log('Evento enviado com sucesso');
            } else {
                console.error('Erro ao enviar o evento:', response.statusText);
            }
        })
        .catch((error) => {
            console.error('Erro ao enviar o evento:', error);
        });
}
