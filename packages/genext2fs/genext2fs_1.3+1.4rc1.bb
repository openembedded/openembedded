include genext2fs.inc

TRIMMEDV = "${@bb.data.getVar('PV', d, 1).split('+')[1]}"
FILESPATH = "${FILE_DIRNAME}/genext2fs-${PV}:${FILE_DIRNAME}/genext2fs:${FILE_DIRNAME}/files"
SRC_URI = "${SOURCEFORGE_MIRROR}/genext2fs/genext2fs-${TRIMMEDV}.tar.gz"
S = "${WORKDIR}/genext2fs-${TRIMMEDV}"
DEFAULT_PREFERENCE = "1"

inherit autotools
