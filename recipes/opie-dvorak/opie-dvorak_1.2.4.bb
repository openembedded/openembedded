require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_inputmethods_dvorak.tar.bz2;name=split_inputmethods_dvorak \
           http://sources.openembedded.org/opie-1.2.4-split_inputmethods_pickboard.tar.bz2;name=split_inputmethods_pickboard \
	   file://fix-rpath.patch "
SRC_URI[split_inputmethods_dvorak.md5sum] = "c4d17b5011fcf7c1558f3d065a38ca87"
SRC_URI[split_inputmethods_dvorak.sha256sum] = "82e0cecae67d5361517e3fab054207fa5f7c9dd3aff7c71ccc28ea7c5aeaab94"
SRC_URI[split_inputmethods_pickboard.md5sum] = "9b569b0bf42f2aea3b007818fd8467d6"
SRC_URI[split_inputmethods_pickboard.sha256sum] = "972f5b8b9689dc7c8571dd1e9ae3baf07b78416fc63b98192b14b0e089efdb7f"
