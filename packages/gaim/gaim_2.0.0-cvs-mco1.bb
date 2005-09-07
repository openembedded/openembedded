PR = "r0"
CVSDATE_${PN} = "20050904"
PV = "2.0.0-cvs-mco1-${CVSDATE}"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/gaim;module=gaim \
	file://no-superimposed-version-on-logo.patch;patch=1 \
	file://01-optional-icons-in-dialogs.patch;patch=1 \
	file://02-request-field-dialogs.patch;patch=1 \
	file://03-blist-dialogs.patch;patch=1 \
	file://04-saved-status-dialogs.patch;patch=1 \
	file://05-statusbox-icon-size.patch;patch=1 \
	file://06-account-dialogs.patch;patch=1 \
	file://07-roomlist-dialog.patch;patch=1 \
	file://define-pda-mode.patch;patch=1 \
	file://desktop-name-2.0.0.patch;patch=1 \
	file://docklet-icon-size.patch;patch=1 \
	file://08-prefs-dialog.patch;patch=1 \
	file://09-filetransfer-dialog.patch;patch=1 \
	file://10-pda-default-settings.patch;patch=1 \
	"

include gaim.inc

S = "${WORKDIR}/gaim"

CFLAGS += "-D_GNU_SOURCE"


DEPENDS += "startup-notification"

#include autopoint (gettext)
EXTRA_AUTORECONF = ""

#disable "X Session Management"... It is EVIL
EXTRA_OECONF += "--disable-sm --enable-startup-notification"
