require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_net_opiestumbler.tar.bz2;name=split_noncore_net_opiestumbler \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
	   file://opiestumbler.png"
SRC_URI[split_noncore_net_opiestumbler.md5sum] = "99f1b7741b9c31212596221fe6fbf110"
SRC_URI[split_noncore_net_opiestumbler.sha256sum] = "14e88b8954dab367334683a5436a7af08bfcd3f18b68268240f3b41fd26e577a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
