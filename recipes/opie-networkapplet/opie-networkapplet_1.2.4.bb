require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_applets_networkapplet.tar.bz2;name=split_noncore_applets_networkapplet \
	   http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_applets_networkapplet.md5sum] = "f8babedc3ff24f690ac3b4e6e58dd9fb"
SRC_URI[split_noncore_applets_networkapplet.sha256sum] = "a5ec944fe25c444be52613f1f179420c19fda1c0f3cd41b67fd93f42de80c6f0"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
