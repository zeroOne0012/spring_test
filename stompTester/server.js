import { Client } from "@stomp/stompjs";

const client = new Client({
  brokerURL: "ws://localhost:8080/ws",
  onConnect: () => {
    client.subscribe("/topic/messages", (msg) => {
      console.log("받은 메시지:", msg.body);
    });

    client.publish({
      destination: "/app/chat/send",
      body: JSON.stringify({ content: "후루룹촵촵!" })
    });
  }
});

client.activate();
