require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_net_opiestumbler.tar.bz2;name=split_noncore_net_opiestumbler \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
	   file://opiestumbler.png"
SRC_URI[split_noncore_net_opiestumbler.md5sum] = "9b8897e9c9c065cd812060ad438eff5e"
SRC_URI[split_noncore_net_opiestumbler.sha256sum] = "b094aed1c458fd2584880bc46b49cceb7f28e85a4911c107780d95fc8b4b7a9b"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
