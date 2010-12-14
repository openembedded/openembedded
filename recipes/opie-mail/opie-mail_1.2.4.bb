require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_net_mail.tar.bz2;name=split_noncore_net_mail \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
	   http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_mail.md5sum] = "69bcf3339aeebc491daf00c06ad54e38"
SRC_URI[split_noncore_net_mail.sha256sum] = "b4fb818b8f6ce1d0eb95ccbab619f3bb0d537aa1669eb854c3fbd50ce621bf22"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
