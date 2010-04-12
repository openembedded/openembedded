require genext2fs.inc

TRIMMEDV = "${@bb.data.getVar('PV', d, 1).split('+')[1]}"
FILESPATH = "${FILE_DIRNAME}/genext2fs-${PV}:${FILE_DIRNAME}/genext2fs:${FILE_DIRNAME}/files"
SRC_URI = "${SOURCEFORGE_MIRROR}/genext2fs/genext2fs-${TRIMMEDV}.tar.gz \
	   file://volume.patch;patch=1"
S = "${WORKDIR}/genext2fs-${TRIMMEDV}"
DEFAULT_PREFERENCE = "1"

inherit autotools

SRC_URI[md5sum] = "664431bf6737df1c265500e1f0b5d40c"
SRC_URI[sha256sum] = "e60f88763ee12c02a5c7ade1a58925ef0ab198f9ec6aaf404747dfc29074c7be"
