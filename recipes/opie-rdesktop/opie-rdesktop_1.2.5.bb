require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_net_opierdesktop.tar.bz2;name=split_noncore_net_opierdesktop \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
	   http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_opierdesktop.md5sum] = "62cdf63ca0c53f2790313c62b48e8c83"
SRC_URI[split_noncore_net_opierdesktop.sha256sum] = "15ea40c6ff7e074debca90dd71a307b427e8b80beae2cb95ae6321da3f09afa5"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
