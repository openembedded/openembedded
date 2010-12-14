require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_applets_cardapplet.tar.bz2;name=split_noncore_applets_cardapplet \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_sounds.tar.bz2;name=split_sounds \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.4-split_etc.tar.bz2;name=split_etc"
SRC_URI[split_noncore_applets_cardapplet.md5sum] = "bdc4cd2d5abcc90298cfc7e81fc63811"
SRC_URI[split_noncore_applets_cardapplet.sha256sum] = "644489e1cf277128a96d0a556fb43964c8430d9b37a22e93a7d307ebd978cfd4"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_sounds.md5sum] = "eab6336ddc7a8b4db9fca94cef2485b1"
SRC_URI[split_sounds.sha256sum] = "a110602cd5013c6a406765f351a8484478617b2002377dd3c02a8bf450ca845f"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_etc.md5sum] = "ed2c78e9ce1525da1f4e262528956fb8"
SRC_URI[split_etc.sha256sum] = "ca2819a56531086ec917f7cd560b8a395dd9c2b10dd996adad5deb64fcd3a537"

