const API_URL = 'http://localhost:5000/api/'; // URL do back-end
const productsContainer = document.getElementById('products-container');
const cartContainer = document.getElementById('cart-container');
const orderContainer = document.getElementById('order-container');
const cart = [];
const orders = [];

document.addEventListener('DOMContentLoaded', () => {
    // Função para buscar produtos da API
    async function fetchProducts() {
        try {
            const response = await fetch(API_URL + 'products');

            if (!response.ok) {
                throw new Error('Erro ao buscar produtos');
            }

            const products = await response.json();
            renderProducts(products);
        } catch (error) {
            console.error(error);
            productsContainer.innerHTML = '<p>Erro ao carregar os produtos.</p>';
        }
    }

    // Função para renderizar os produtos como cards
    function renderProducts(products) {
        productsContainer.innerHTML = ''; // Limpa o conteúdo anterior

        products.forEach((product) => {
            const card = `
          <div class="card">
            <img src="${product.image}" alt="${product.name}">
            <h2>${product.name}</h2>
            <p>${product.description}</p>
            <p><strong>R$ ${product.price.toFixed(2)}</strong></p>
            <button onclick="addCart(${product.id})">Adicionar ao carrinho</button>
          </div>
        `;
            productsContainer.insertAdjacentHTML('beforeend', card);
        });
    }

    // Carregar os produtos assim que a página abrir
    fetchProducts();
});

// função para adicionar produtos ao carrinho deve receber id do produto
async function addCart(id) {
    try {
        const response = await fetch(API_URL + 'cart/' + id);
        if (!response.ok) {
            throw new Error(response.status);
        }

        const products = await response.json();
        const product = products[0];
        const productCart = cart.find((item) => item.id === product.id);
        if (productCart) {
            productCart.quantity += 1; // Incrementa a quantidade
            updateCartItem(productCart);
        } else {
            product.quantity = 1;
            cart.push(product);
            renderProductCart(product);
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

function renderProductCart(product) {

    // Cria o HTML do card com o contador
    const card = `
      <div class="card cart" id="cart-item-${product.id}">
        <img src="${product.image}" alt="${product.name}">
        <h2>${product.name}</h2>
        <p><strong>R$ ${product.price.toFixed(2)}</strong></p>
        
        <label>Quantidade:</label> 
        <div>
            <button onclick="removeCartItem(${product.id})">-</button>
            <span id="quantity-${product.id}">${product.quantity}</span>
            <button onclick="addCart(${product.id})">+</button>
        </div>
      </div>
    `;
    cartContainer.insertAdjacentHTML('beforeend', card);
}


function updateCartItem(product) {
    // Atualiza apenas o contador de quantidade no HTML
    const quantityElement = document.getElementById(`quantity-${product.id}`);

    if (quantityElement) {
        quantityElement.textContent = product.quantity;
    }
}
function removeCartItem(id) {
    // Remove um item do carrinho
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
        console.log(cart)
        console.log(JSON.stringify(cart))
        const response = await fetch(API_URL + 'order', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(cart),
        });


        if (!response.ok) {
            throw new Error(response);
        }
        const order = await response.json();
        console.log(order)
        cartContainer.innerHTML = ''; // Limpa o carrinho
        // Limpa o objeto cart
        cart.length = 0;

        orders.push(order);
        renderCardOrder(order);
    } catch (error) {
        console.error(error);
        alert('Erro ao fazer pedido');
    }
}

function renderCardOrder(order) {
    // Cria o HTML do card do pedido
    console.log(order)
    const card = `
      <div class="card order" id="order-item-${order.id}">
        <h2>Pedido ${order.id}</h2>
        <p><strong>R$ ${order.total.toFixed(2)}</strong></p>
        <p>Produtos:</p>
        <ul>
            ${order.cart.map((product) => `<li>${product.name} - ${product.quantity} unidade(s)</li>`).join('')}
        </ul>
        <p>Status: ${order.status}</p>
        </div>
    `;
    orderContainer.insertAdjacentHTML('beforeend', card);
}