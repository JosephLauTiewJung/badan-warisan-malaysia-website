const ChatboxItem = ({ messages }) => {
    console.log(messages);
    return (
        messages.map((message, index) => (
            <div
                className={`flex flex-col ${message.sender === 'user' ? 'items-end' : 'items-start'} space-y-2 mt-3 mr-2`}
                key={index}
            >
                <div className={`relative max-w-xs px-4 py-2 text-white ${message.sender === 'user' ? 'bg-blue-600' : 'bg-purple-600'} rounded-lg text-xl`}>
                    <span>{message.text}</span>
                </div>
            </div>
        ))
    );
};

export default ChatboxItem;