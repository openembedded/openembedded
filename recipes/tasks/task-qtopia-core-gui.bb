HOMEPAGE = "http://www.trolltech.com"
LICENSE = "MIT"

inherit task

DESCRIPTION_task-qtopia-core-gui = "QtopiaCore GUI library"
RDEPENDS_task-qtopia-core-gui = " \
    task-qtopia-core-console \
    libqtopiacoregui4 \
    libqtopiacorescript4 \
    libqtopiacoredbus4"
