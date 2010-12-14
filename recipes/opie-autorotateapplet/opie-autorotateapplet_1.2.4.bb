require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_applets_autorotateapplet.tar.bz2;name=split_noncore_applets_autorotateapplet \
	   http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_applets_autorotateapplet.md5sum] = "54b35b939b43c01f610d309b6b4cdeaa"
SRC_URI[split_noncore_applets_autorotateapplet.sha256sum] = "dd33fa4ee8ac6be8cdde2234b4bef78e49d72fca7f2ace96cae65b62af934b17"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
