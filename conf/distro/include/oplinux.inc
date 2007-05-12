#
# extra checking for needed tools
#

# set minimal version of BitBake needed
BB_MIN_VERSION = "1.6.3"
#OPLinux and OPLinux-uclibc source mirrors
INHERIT += "oplinux-mirrors"

#oplinux is a multimachine distro
INHERIT += "multimachine"

# check for required tools and minimal BitBake version
INHERIT += "sanity"


#
# Naming schemes
#
PARALLEL_INSTALL_MODULES = "1"
INHERIT += "package_ipk debian"

#
# Packaging and output format

IMAGE_FSTYPES = "tar jffs2 ext2 cramfs squashfs squashfs-lzma cpio.gz"




# Specifies a location to search for pre-generated tarballs when fetching
# a cvs:// URI. Outcomment this, if you always want to pull directly from CVS.
#CVS_TARBALL_STASH = "http://www.digital-opsis.com/oplinux/source/current/"

#INHERIT += "owmnr-mirrors"

#Uncommend this is if you are using bitbake multithread and you have multiple cpu's or cores you are running on
#BB_NUMBER_THREADS = "5"

#Uncommend this if you hava icecc installed
#INHERIT += "icecc"
#PARALLEL_MAKE = "-j6"
#ICECC_PATH = "/usr/bin/icecc"
#ICECC_ENV_EXEC = "/home/stelios/icecc-create-env"

#
# Bootstrap & Init
PREFERRED_PROVIDER_task-bootstrap = "task-base"

# We want images supporting the following features (for task-base
DISTRO_FEATURES = "nfs smbfs ext2 pcmcia usbgadget usbhost pci"


OPLINUX_URI = "http://www.ifaistos.awmn/oplinux"
OPLINUX-uCLIBC_URI = "http://www.ifaistos.awmn/oplinux-uclibc"

#Dir config
IMAGE_ROOTFS = "${TMPDIR}/rootfs/${MACHINE}"

#
#Preferred versions of packages we need
#
PREFERRED_VERSION_busybox = "1.2.1"
PREFERRED_VERSION_u-boot ?= "1.1.4"
# Latest linphone supports yeaphone
PREFERRED_VERSION_linphone ?= "1.6.0"


