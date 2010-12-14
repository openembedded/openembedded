require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_net_opieirc.tar.bz2;name=split_noncore_net_opieirc \
           http://sources.openembedded.org/opie-1.2.4-split_help.tar.bz2;name=split_help \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
	   http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_opieirc.md5sum] = "fdd0aff6d1f604f8c095db283877763e"
SRC_URI[split_noncore_net_opieirc.sha256sum] = "8e1625e1be84df3efda3b7be05918feb6fd79f08c02e5eda58dd1088a471c70b"
SRC_URI[split_help.md5sum] = "ce138d39070637cefe6e746e3a32c8c4"
SRC_URI[split_help.sha256sum] = "107c9e70503bed901593cc34a270245f02104142dd940c5835a656521922394a"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
