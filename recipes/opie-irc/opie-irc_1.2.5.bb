require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_net_opieirc.tar.bz2;name=split_noncore_net_opieirc \
           http://sources.openembedded.org/opie-1.2.5-split_help.tar.bz2;name=split_help \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
	   http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_opieirc.md5sum] = "9c425f43ec2575925121a31ab988ea67"
SRC_URI[split_noncore_net_opieirc.sha256sum] = "0bf63dfced107a72458d09a661a386bc4f977709c9fd40217c46f1bece9fa672"
SRC_URI[split_help.md5sum] = "43393aaa1840e4f6e2c2a3397e451e2a"
SRC_URI[split_help.sha256sum] = "6e4e3e7d626611a78e34343f88ebd8a6e5e7255be23859b7cd166b2575cbb632"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
