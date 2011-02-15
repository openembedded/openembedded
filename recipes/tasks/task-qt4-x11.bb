DESCRIPTION = "QT4-X11 base Image Feed"
PR = "r1"
LICENSE = "MIT"

inherit task

PACKAGES += " \
	${PN}-base \
	${PN}-qwt \
"

RDEPENDS_${PN}-base = " \
	qt4-x11-free \
        libqt3support4 \
        libqtclucene4 \
        libqtcore4 \
        libqtdbus4 \
        libqtgui4 \
        libqthelp4 \
        libqtmultimedia4 \
        libqtnetwork4 \
        libqtscript4 \
        libqtscripttools4 \
        libqtsql4 \
        libqtsvg4 \
        libqttest4 \
        libqtwebkit4 \
        libqtxml4 \
        qt4-fonts \
        qt4-plugin-iconengine-svgicon \
        qt4-plugin-imageformat-gif \
        qt4-plugin-imageformat-ico \
        qt4-plugin-imageformat-jpeg \
        qt4-plugin-imageformat-mng \
        qt4-plugin-imageformat-svg \
        qt4-plugin-imageformat-tiff \
        qt4-plugin-phonon-backend-gstreamer \
        qt4-plugin-script-dbus \
        qt4-plugin-sqldriver-sqlite2 \
        qt4-plugin-sqldriver-sqlite \
"

RRECOMMENDS_${PN}-base = " \
        libqtxmlpatterns4 \
"

RDEPENDS_${PN}-qwt = "\
        qwt \
"
