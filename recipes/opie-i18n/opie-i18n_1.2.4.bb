require ${PN}.inc

PR = "r1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_i18n.tar.bz2 \
	   http://sources.openembedded.org/opie-1.2.4-split_etc_dict.tar.bz2"
