require ${PN}.inc
PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_pim_notes.tar.bz2;name=split_core_pim_notes \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
	   file://gcc-4.5-non-trivially-copyable-fix.patch \
	  "
SRC_URI[split_core_pim_notes.md5sum] = "e3862fb0314e3ce0dee7f80afa616671"
SRC_URI[split_core_pim_notes.sha256sum] = "530c1f01b8526e46bcfc932b868c953092d6b6c20c666bd9b3e12105bcf8f139"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
