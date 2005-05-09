include orinoco-modules_0.13e.bb

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/orinoco-modules-0.13e"

SRC_URI = "http://www.tzi.de/~plasmahh/orinoco-0.13e-SN-6.tar.bz2 \
           file://add-spectrum-support.patch;patch=1 \
           file://use-cs-error.patch;patch=1 \
           file://remove-slot-name.patch;patch=1 \
           file://spectrum.conf \
           file://orinoco_cs.conf"
S = "${WORKDIR}/orinoco-0.13e-SN-6"

PR = "r2"

# use only w/ kernel 2.6
DEFAULT_PREFERENCE_arm = "-1"
MAKE = "make -e"

