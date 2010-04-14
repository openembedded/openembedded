require openvpn.inc

SRC_URI = "http://openvpn.net/release/old/openvpn-${PV}.tar.gz \
        file://openvpn"

SRC_URI[md5sum] = "55d7ce958bb2ccf3d3204d1350c27179"
SRC_URI[sha256sum] = "d34d0a1a29de12cbb4fc6f8d80eced7b674ee3574e3df3d678fb0467283f7826"

PR = "r3"
