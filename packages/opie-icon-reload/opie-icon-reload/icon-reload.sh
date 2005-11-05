#!/bin/sh

/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadInputMethods()"                                            
/opt/QtPalmtop/bin/qcop QPE/System "linkChanged(QString)" 
