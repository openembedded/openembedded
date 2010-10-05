DESCRIPTION = "Target packages for Qt Embedded SDK"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r5"

RDEPENDS_${PN} += " \
        task-sdk-bare \
        qt4-mkspecs \
        libqtmultimedia4-dev \
        libqtphonon4-dev \
        libqt3support4-dev \
        libqtclucene4-dev \
        libqtcore4-dev \
        libqtdbus4-dev \
        libqtdesignercomponents4-dev \
        libqtdesigner4-dev \
        libqtuitools4-dev \
        libqtgui4-dev \
        libqthelp4-dev \
        libqtnetwork4-dev \
        libqtscript4-dev \
        libqtscripttools4-dev \
        libqtsql4-dev \
        libqtsvg4-dev \
        libqttest4-dev \
        libqtwebkit4-dev \
        libqtxml4-dev \
        libmysqlclient-dev \
        sqlite-dev \
        libsqlite-dev \
        libts-dev \
        expat-dev \
        "

#Qt Declarative is new in 4.7, try to include it like this.
RRECOMMENDS_${PN} += " \
        libqtdeclarative4-dev \
        "
