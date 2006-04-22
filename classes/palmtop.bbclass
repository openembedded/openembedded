# this build class sets up qmake variables to
#   * build using the Qt Windowing System (QWS)
#   * use qt
#   * link against supc++ instead of stdc++  
#   * use threads, if requested via PALMTOP_USE_MULTITHREADED_QT = "yes"
# inherit this class to build programs against libqpe
# inherit opie if you want to build programs against libopie2

inherit qmake

EXTRA_QMAKEVARS_POST += "DEFINES+=QWS LIBS+=-lqpe CONFIG+=qt LIBS-=-lstdc++ LIBS+=-lsupc++"
EXTRA_QMAKEVARS_POST += "${@base_conditional("PALMTOP_USE_MULTITHREADED_QT", "yes", "CONFIG+=thread", "",d)}'

DEPENDS_prepend = "virtual/libqpe1 uicmoc-native "

FILES_${PN} = "${palmtopdir}"
