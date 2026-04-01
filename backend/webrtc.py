# base WebRTC (simplifiée)

from aiortc import RTCPeerConnection

pcs = []

async def create_peer():
    pc = RTCPeerConnection()
    pcs.append(pc)
    return pc