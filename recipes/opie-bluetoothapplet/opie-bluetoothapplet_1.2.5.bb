require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_net_opietooth_applet.tar.bz2;name=split_noncore_net_opietooth_applet \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_opietooth_applet.md5sum] = "d62580896f19fcde7c901f5271633c3a"
SRC_URI[split_noncore_net_opietooth_applet.sha256sum] = "1997ffbf4762a52ad0cf3c01b4fd9f717ca6e32f306f28b6b7d5cedc7acc3789"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
