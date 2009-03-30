HOMEPAGE = "http://www.trolltech.com"
LICENSE = "MIT"

inherit task

DESCRIPTION_task-qtopia-core-gui = "QtopiaCore GUI library"
RDEPENDS_task-qtopia-core-gui = " \
    task-qtopia-core-console \
    libqt-embeddedgui4 \
    libqt-embeddedscript4 \
    libqt-embeddeddbus4"
