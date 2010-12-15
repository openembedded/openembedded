require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_applets_networkapplet.tar.bz2;name=split_noncore_applets_networkapplet \
	   http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_applets_networkapplet.md5sum] = "cff6a34cb17c4d43fac479af928e945d"
SRC_URI[split_noncore_applets_networkapplet.sha256sum] = "83f69e44ba07b84abdab915dcfaccf25257e23b8904bf71ac01080b484f850f0"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
