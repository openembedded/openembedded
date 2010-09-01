DESCRIPTION = "A stackable unification file system, which can appear to \
merge the contents of several directories (branches), while keeping their \
physical content separate."
HOMEPAGE = "http://www.fsl.cs.sunysb.edu/project-unionfs.html"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.fsl.cs.sunysb.edu/pub/unionfs/OLD/unionfs-1.x/unionfs-${PV}.tar.gz"
S = "${WORKDIR}/unionfs-${PV}"

export UCFLAGS = '${CFLAGS} -DNODEBUG -DUNIONFS_VERSION=\\"${PV}\\"'
CFLAGS = "${BUILD_OPTIMIZATION}"
TARGET_CC_ARCH += "${LDFLAGS}"

INC_PR = "r1"
