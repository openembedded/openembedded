PR = "r3"
SRCDATE_${PN} = "20050904"
#Change to x.y.z+cvs${SRCDATE}-mco1 when 2.0.0 changes
PV = "2.0.0-cvs-mco1-${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

WEBCVSURL = "http://handhelds.org/cgi-bin/cvsweb.cgi/~checkout~/gaim"

SRC_URI = "cvs://anonymous@gaim.cvs.sourceforge.net/cvsroot/gaim;module=gaim \
	${WEBCVSURL}/no-superimposed-version-on-logo.patch \
	${WEBCVSURL}/01-optional-icons-in-dialogs.patch \
	${WEBCVSURL}/02-request-field-dialogs.patch \
	${WEBCVSURL}/03-blist-dialogs.patch \
	${WEBCVSURL}/04-saved-status-dialogs.patch \
	${WEBCVSURL}/05-statusbox-icon-size.patch \
	${WEBCVSURL}/06-account-dialogs.patch \
	${WEBCVSURL}/07-roomlist-dialog.patch \
	${WEBCVSURL}/define-pda-mode.patch \
	${WEBCVSURL}/desktop-name-2.0.0.patch \
	${WEBCVSURL}/docklet-icon-size.patch \
	${WEBCVSURL}/08-prefs-dialog.patch \
	${WEBCVSURL}/09-filetransfer-dialog.patch \
	${WEBCVSURL}/10-pda-default-settings.patch \
	file://gaim-OE-branding.patch \
	"

require gaim.inc

S = "${WORKDIR}/gaim"

CFLAGS += "-D_GNU_SOURCE"


DEPENDS += "startup-notification"

#include autopoint (gettext)
EXTRA_AUTORECONF = ""

#disable "X Session Management"... It is EVIL
EXTRA_OECONF += "--disable-sm --enable-startup-notification \
                 --with-gnutls-includes=${STAGING_INCDIR}"


