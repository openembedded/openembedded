require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_inputmethods_keyboard.tar.bz2;name=split_inputmethods_keyboard \
	file://fix-rpath.patch "
SRC_URI[split_inputmethods_keyboard.md5sum] = "1dbd6f1c8932b2ab8401a58087ac41d5"
SRC_URI[split_inputmethods_keyboard.sha256sum] = "35adc10231ef8f60668654b8818d6e6695c45d8af5b7863bfbad045d3bd01957"
