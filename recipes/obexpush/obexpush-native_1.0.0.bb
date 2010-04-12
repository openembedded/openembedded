require obexpush_${PV}.bb
inherit native

FILESPATH = "${FILE_DIRNAME}/obexpush-${PV}:${FILE_DIRNAME}/obexpush:${FILE_DIRNAME}/files:${FILE_DIRNAME}"

do_stage() {
	:
}

do_install() {
	:
}


SRC_URI[md5sum] = "edb66ba97fe6c84b6160c670c4bcdea8"
SRC_URI[sha256sum] = "341c6865aa392b6cf056e1bd9cda53d2f31a942460087ad22d6f6dc91bb0bd0e"
