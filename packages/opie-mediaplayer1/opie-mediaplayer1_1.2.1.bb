include ${PN}.inc

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/multimedia/opieplayer \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

EXTRA_QMAKEVARS_POST += "HEADERS+=rssparser.h SOURCES+=rssparser.cpp"
