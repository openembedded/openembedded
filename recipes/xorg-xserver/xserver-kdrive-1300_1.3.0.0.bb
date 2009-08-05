# Build xserver-kdrive as xserver-kdrive-1300 to allow them to co-exist in feeds.
# akita and spitz needs them:
FILESPATH = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xserver-kdrive-1.3.0.0:${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xserver-kdrive:${@os.path.dirname(bb.data.getVar('FILE',d,1))}/files"

PKGN = xserver-kdrive-1300
require xserver-kdrive_1.3.0.0.bb

PR_append = ".1"

RPROVIDES_${PKGN}-fbdev_angstrom += "xserver-kdrive-fbdev"
RREPLACES_${PKGN}-fbdev_angstrom += "xserver-kdrive-fbdev"
RCONFLICTS_${PKGN}-fbdev_angstrom += "xserver-kdrive-fbdev"

RREPLACES_${PN}_angstrom += xserver-kdrive
RREPLACES_${PN}-dev_angstrom += xserver-kdrive-dev
RREPLACES_${PN}-doc_angstrom += xserver-kdrive-doc

RPROVIDES_${PN} += xserver-kdrive
RPROVIDES_${PN}-dev += xserver-kdrive-dev
RPROVIDES_${PN}-doc += xserver-kdrive-doc
