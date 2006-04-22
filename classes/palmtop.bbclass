# basically a placeholder for something more fancy
# for now, just declare some things

inherit qmake

EXTRA_QMAKEVARS_POST_append = " DEFINES+=QWS LIBS+=-lqpe CONFIG+=qt CONFIG+=thread LIBS-=-lstdc++ LIBS+=-lsupc++"

DEPENDS_prepend = "virtual/libqpe1 uicmoc-native "

FILES_${PN} = "${palmtopdir}"
