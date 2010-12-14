require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_lockapplet.tar.bz2;name=split_core_applets_lockapplet \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_core_applets_lockapplet.md5sum] = "c522bc679f1906f613b52f76a29545d8"
SRC_URI[split_core_applets_lockapplet.sha256sum] = "0b159e9de998557f85afcea93dd8a547e2c4c9fd807497860082ad2c42b9fa54"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
