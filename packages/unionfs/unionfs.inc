DESCRIPTION = "A stackable unification file system, which can appear to \
merge the contents of several directories (branches), while keeping their \
physical content separate."
HOMEPAGE = "http://www.fsl.cs.sunysb.edu/project-unionfs.html"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.fsl.cs.sunysb.edu/pub/unionfs/unionfs-${PV}.tar.gz \
	   file://make.patch;patch=1"
S = "${WORKDIR}/unionfs-${PV}"
FILESPATH = "${FILE_DIRNAME}/unionfs-${PV}:${FILE_DIRNAME}/unionfs:${FILE_DIRNAME}/files:${FILE_DIRNAME}"

export UCFLAGS := "${CFLAGS} -DNODEBUG"
CFLAGS = "${BUILD_OPTIMIZATION}"
