require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_tools_opie-sh.tar.bz2;name=split_noncore_tools_opie-sh \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_help.tar.bz2;name=split_help \
           http://sources.openembedded.org/opie-1.2.5-split_share.tar.bz2;name=split_share \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.5-split_bin.tar.bz2;name=split_bin"
SRC_URI[split_noncore_tools_opie-sh.md5sum] = "93f44cbe6ccfd11ac68a934f623604ae"
SRC_URI[split_noncore_tools_opie-sh.sha256sum] = "fc1d5ad1de203dbf6c81c7d863f524c8abe81f5a6d5c736f97ea8cc99bb208a5"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_help.md5sum] = "43393aaa1840e4f6e2c2a3397e451e2a"
SRC_URI[split_help.sha256sum] = "6e4e3e7d626611a78e34343f88ebd8a6e5e7255be23859b7cd166b2575cbb632"
SRC_URI[split_share.md5sum] = "a715ae54405cae2b17c35d166f161aa8"
SRC_URI[split_share.sha256sum] = "0b71c8726b41f8c4dfd3a31fbb23f9c533c16d7d9c1f3002ab0d2daea274da7a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_bin.md5sum] = "1de9fd3614f11496ef9d4cfa37c1ad80"
SRC_URI[split_bin.sha256sum] = "f386414463138249c6f335d167beaebdf797de214727789ab2ada732e02f71a2"
