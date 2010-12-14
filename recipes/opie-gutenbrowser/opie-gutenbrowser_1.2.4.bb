require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_apps_opie-gutenbrowser.tar.bz2;name=split_noncore_apps_opie-gutenbrowser \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
	   http://sources.openembedded.org/opie-1.2.4-split_etc.tar.bz2;name=split_etc"
SRC_URI[split_noncore_apps_opie-gutenbrowser.md5sum] = "118ef6f0319155effbf49a4f7dcdb73d"
SRC_URI[split_noncore_apps_opie-gutenbrowser.sha256sum] = "8a401673d3902d91bfee731c3c584880f525d621631ead949e2c876f92538407"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_etc.md5sum] = "ed2c78e9ce1525da1f4e262528956fb8"
SRC_URI[split_etc.sha256sum] = "ca2819a56531086ec917f7cd560b8a395dd9c2b10dd996adad5deb64fcd3a537"
