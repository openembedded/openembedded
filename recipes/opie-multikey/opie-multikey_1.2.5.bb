require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_inputmethods_multikey.tar.bz2;name=split_inputmethods_multikey \
           http://sources.openembedded.org/opie-1.2.5-split_share.tar.bz2;name=split_share \
           file://fix-rpath.patch"
SRC_URI[split_inputmethods_multikey.md5sum] = "fe9401e13070fb458701cc416ccbab0b"
SRC_URI[split_inputmethods_multikey.sha256sum] = "a26bbc5db64dc6c904324a7b3ddbe4e3ba303eb648dcb19760b2ef214e2f7ebf"
SRC_URI[split_share.md5sum] = "a715ae54405cae2b17c35d166f161aa8"
SRC_URI[split_share.sha256sum] = "0b71c8726b41f8c4dfd3a31fbb23f9c533c16d7d9c1f3002ab0d2daea274da7a"

#           file://friendly-button-names.patch"
