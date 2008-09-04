
# Ugly, use qt4 from the buildhost till someone adds a qt4-native recipe

EXTRA_OECMAKE = "-DQT_LIBRARY_DIR=/usr/lib \
                 -DQT_INSTALL_LIBS=/usr/lib \
		 -DQT_INCLUDE_DIR=/usr/include/qt4 \
		 -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
		 -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
		 -DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
		 -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
		 -DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
		 -DQT_QTCORE_INCLUDE_DIR=/usr/include/qt4/QtCore \
		 "

