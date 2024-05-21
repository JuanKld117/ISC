document.addEventListener("DOMContentLoaded", function() {
    const chatHistory = document.getElementById("chat-history");
    const userInput = document.getElementById("user-input");
    const sendButton = document.getElementById("send-button");

    sendButton.addEventListener("click", function() {
        const question = userInput.value.trim();
        if (question !== "") {
            appendMessage("Usuario", question);
            userInput.value = "";
            sendQuestion(question);
        }
    });

    function appendMessage(sender, message) {
        const messageElement = document.createElement("div");
        messageElement.classList.add("message");
        messageElement.innerHTML = `<strong>${sender}:</strong> ${message}`;
        chatHistory.appendChild(messageElement);
        chatHistory.scrollTop = chatHistory.scrollHeight;
    }

    function sendQuestion(question) {
        const data = { prompt: question };
        fetch("https://fi.jcaguilar.dev/v1/chat", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(data => {
            const answer = data.text;
            appendMessage("Chappie", answer);
        })
        .catch(error => {
            console.error("Error:", error);
            appendMessage("Chappie", "Lo siento, ha ocurrido un error.");
        });
    }    
});