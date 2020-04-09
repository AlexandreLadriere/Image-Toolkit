#!/bin/bash

# Paths
SRC_PATH="src/"
OUT_PATH="out/"
DOC_PATH="doc/"

# Commands
BUILD="build"
BUILD_DESC="Build all .class files"
DOC="doc"
DOC_DESC="Create all javadoc"
RESIZE="resize"
RESIZE_DESC="Run the 'resize' function.
* arg 1: Path of the image that you want to resize (e.g.: C:/user/image/test.jpg)
      /!\\ the '\\' symbol is not allowed !
* arg 2: Path where you want to save the resized image (with filename and extension) (e.g.: C:/user/image/test_resized.png)
      /!\\ the '\\' symbol is not allowed !
* arg 3: New Width in px (integer, e.g.: 230)
* arg 4: New Height in px (integer, e.g.: 340)
* arg 5: Boolean to indicate resize speed. 'true': good quality but slow; 'false': fast resize

"
RESIZE_RATIO="resize_ratio"
RESIZE_RATIO_DESC="Run the 'resize_ratio' function.
* arg 1: Path of the image that you want to resize (e.g.: C:/user/image/test.jpg)
      /!\\ the '\\' symbol is not allowed !
* arg 2: Path where you want to save the resized image (with filename and extension) (e.g.: C:/user/image/test_resized_ratio.png)
      /!\\ the '\\' symbol is not allowed !
* arg 3: Ratio in % (integer, e.g.: 200)
* arg 4: Boolean to indicate resize speed. 'true': good quality but slow; 'false': fast resize

"
CONVERT="convert"
CONVERT_DESC="Run the 'convert' function.
* arg 1: Path of the image that you want to convert. (e.g.: C:/user/image/test.jpg)
* arg 2: Path where you want to save the new image (with filename and new extension) ((e.g.: C:/user/image/test_convert.jpg)

"
CLEAN="clean"
CLEAN_DESC="Clean the current repository from all created files"

# Files list
declare -a CLASSES=(
  "alexandreladriere/imagetoolkit/utils/Constants.java"
  "alexandreladriere/imagetoolkit/utils/FilePathManipulation.java"
  "alexandreladriere/imagetoolkit/utils/ImageExtensions.java"
  "alexandreladriere/imagetoolkit/ImageToolkit.java"
  "Main.java"
)

# Main class name (without extension)
MAIN="Main"

function build() {
  # Builds all .class files which are in the $CLASSES array into the $OUT_PATH folder
  echo "Building .class files..."
  mkdir -p $OUT_PATH
	cd $SRC_PATH || exit
	echo "cd $SRC_PATH"
  for i in "${CLASSES[@]}"
  do
    echo "javac -d ../$OUT_PATH ""$i"""
    javac -d ../${OUT_PATH} "$i"
  done
  echo "cd .."
  cd ..
  echo "All .class files have been built !"
}

function resize() {
  # Runs the $MAIN class for "resize" option
  if [ ! -d "$OUT_PATH" ]; then # checks if $OUT_PATH exists
    echo "$OUT_PATH does not exist"
    build
  fi
  if [ ! -f "${OUT_PATH}${MAIN}.class" ]; then # checks if $MAIN.class file exists
    echo "${MAIN}.class does not exist"
    build
  fi
  cd $OUT_PATH || exit
  echo "cd $OUT_PATH"
  echo "Running: $MAIN resize $1 $2 $3 $4 $5"
  java $MAIN "resize" "$1" "$2" "$3" "$4" "$5"
  echo "Done !"
  echo "cd .."
  cd ..
  echo "exit"
  exit
}

function resize_ratio() {
  # Runs the $MAIN class for "resize_ratio" option
  if [ ! -d "$OUT_PATH" ]; then # checks if $OUT_PATH exists
    echo "$OUT_PATH does not exist"
    build
  fi
  if [ ! -f "${OUT_PATH}${MAIN}.class" ]; then # checks if $MAIN.class file exists
    echo "${MAIN}.class does not exist"
    build
  fi
  cd $OUT_PATH || exit
  echo "cd $OUT_PATH"
  echo "Running: $MAIN resize_ratio $1 $2 $3 $4"
  java $MAIN "resize_ratio" "$1" "$2" "$3" "$4"
  echo "Done !"
  echo "cd .."
  cd ..
  echo "exit"
  exit
}

function convert() {
  # Runs the $MAIN class for "convert" option
  if [ ! -d "$OUT_PATH" ]; then # checks if $OUT_PATH exists
    echo "$OUT_PATH does not exist"
    build
  fi
  if [ ! -f "${OUT_PATH}${MAIN}.class" ]; then # checks if $MAIN.class file exists
    echo "${MAIN}.class does not exist"
    build
  fi
  cd $OUT_PATH || exit
  echo "cd $OUT_PATH"
  echo "Running: $MAIN convert $1 $2"
  java $MAIN "convert" "$1" "$2"
  echo "Done !"
  echo "cd .."
  cd ..
  echo "exit"
  exit
}

function clean() {
  # Removes the $OUT_PATH folder
  echo "Cleaning folder..."
  if [ ! -d "$OUT_PATH" ]; then # checks if $OUT_PATH exists]
    echo "Nothing to clean"
  else
    rm -r $OUT_PATH
    rm -r $DOC_PATH
    echo "Folder cleaned"
    exit
  fi
  exit
}

function create_javadoc() {
  # Create all javadoc
  echo "Creating javadoc..."
  mkdir -p $DOC_PATH
  echo "javadoc -d ../$DOC_PATH alexandreladriere.imagetoolkit alexandreladriere.imagetoolkit.utils"
  javadoc -d ${DOC_PATH} -sourcepath $SRC_PATH -subpackages alexandreladriere.imagetoolkit
  echo "cd .."
  cd ..
  echo "All documentation have been created !"
  exit
}

function help() {
  echo "You have to give only one arguments to this script. These are the allowed arguments:"
  echo "$BUILD         ->     $BUILD_DESC"
  echo "$DOC           ->     $DOC_DESC"
  echo "$RESIZE        ->     $RESIZE_DESC"
  echo "$RESIZE_RATIO  ->     $RESIZE_RATIO_DESC"
  echo "$CONVERT       ->     $CONVERT_DESC"
  echo "$CLEAN         ->     $CLEAN_DESC"
  exit
}

### Main body ###
if [ "$1" == $BUILD ]; then
  build
  exit
fi

if [ "$1" == $DOC ]; then
  create_javadoc
fi

if [ "$1" == $RESIZE ]; then
  resize "$2" "$3" "$4" "$5" "$6"
fi

if [ "$1" == $RESIZE_RATIO ]; then
  resize_ratio "$2" "$3" "$4" "$5"
fi

if [ "$1" == $CONVERT ]; then
  convert "$2" "$3"
fi

if [ "$1" == $CLEAN ]; then
  clean
fi

# if the command is not recognized (if the command is recognized, we never reach this point)
echo "Argument not recognized"
help