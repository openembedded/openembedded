require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_inputmethods_keyboard.tar.bz2;name=split_inputmethods_keyboard \
	file://fix-rpath.patch "
SRC_URI[split_inputmethods_keyboard.md5sum] = "058e514b14409f6b25b2b1fe1bd9290c"
SRC_URI[split_inputmethods_keyboard.sha256sum] = "30981650c11d17e615381390edf0f16d636748b7286d682499fba6165e410011"
