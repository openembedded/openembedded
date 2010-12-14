require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_net_opietooth_manager.tar.bz2;name=split_noncore_net_opietooth_manager \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_opietooth_manager.md5sum] = "d26e07f1ae2f071d6b918a6b8659d5b7"
SRC_URI[split_noncore_net_opietooth_manager.sha256sum] = "67a1dcdcdbca103a508c6b8e3623be2cf846e343b9e7ef06f1b387f001564fb7"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
