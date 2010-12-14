require ${PN}.inc

PR = "r2"
SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
