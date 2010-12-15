require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_inputmethods_dvorak.tar.bz2;name=split_inputmethods_dvorak \
           http://sources.openembedded.org/opie-1.2.5-split_inputmethods_pickboard.tar.bz2;name=split_inputmethods_pickboard \
	   file://fix-rpath.patch "
SRC_URI[split_inputmethods_dvorak.md5sum] = "d0e715138c79b1f7dcd32b6ab3cd69fd"
SRC_URI[split_inputmethods_dvorak.sha256sum] = "ab2f46b1919b627234b5c29e06c7cd043d07fa706e12e1e0dd52f0a6b88d4eb2"
SRC_URI[split_inputmethods_pickboard.md5sum] = "86a0f938b5c65a388ee3ccd8b962e831"
SRC_URI[split_inputmethods_pickboard.sha256sum] = "5c50eb3062443ca3fa249ec1c8fa7b141b4ed3524e907a3c51e6ee8c09f6f8bc"
