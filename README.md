# Image toolkit

[![GitHub license](https://img.shields.io/github/license/AlexandreLadriere/Image-Toolkit.svg)](https://github.com/AlexandreLadriere/Image-Toolkit/blob/master/LICENSE)
[![GitHub forks](https://img.shields.io/github/forks/AlexandreLadriere/Image-Toolkit.svg)](https://github.com/AlexandreLadriere/Image-Toolkit)

I often need to quickly resize or crop images. In order to do that, I used to use an online converter/tool. 
However, sometimes I don't have an Internet connection, so I decided to develop my own tool (and also because I have nothing else to do during this Covid-19 crisis).

Currently, you can:
- Resize an image (by specifying new dimensions or by using a ratio)
- Crop an image
- Rotate an image
- Make rounded corners
- Convert an image to another format (see the list of supported formats below)

These are the supported formats:
- ``.png``
- ``.bmp``
- ``.jpg``
- ``.jpeg``
- (``.gif`` might be added later)

## How to use
You can compile and run this tool by yourself OR you can use my [make.sh] script to do some basic actions:

__Note:__ When you specify a path, __DO NOT USE__ the ``'\'`` character.
#### Build all .class files
```shell script
$ sh make.sh build
```

#### Resize an image (by specifying dimensions in px)
```shell script
$ sh make.sh resize path/of/image/to/resize.ext path/of/resized/image.ext width height 'bool'

# 'bool'=true if you want high quality (but slow process); 'bool'=false if you want quick process

# Example:
$ sh make.sh resize C:/user/image/test.jpg C:/user/image/test_resized.png 245 435 true
```

#### Resize an image (by using a ratio in %)
```shell script
$ sh make.sh resize_ratio path/of/image/to/resize.ext path/of/resized/image.ext ratio 'bool'

# 'bool'=true if you want high quality (but slow process); 'bool'=false if you want quick process

# Example:
$ sh make.sh resize_ratio C:/user/image/test.jpg C:/user/image/test_resized_ratio.png 80 true
```

#### Convert an image
```shell script
$ sh make.sh convert path/of/image/to/convert.ext path/of/converted/image.ext

# Example:
$ sh make.sh convert C:/user/image/test.jpg C:/user/image/test_converted.png
```

#### Clean
```shell script
$ sh make.sh clean
```

#### Create Javadoc
```shell script
$ sh make.sh doc
```


## Structure
The [ImageToolkit.java] contains all needed functions to transform an image. If you want to use it, you just have to download and import the package:
```java
import alexandreladriere.imagetoolkit.ImageToolkit;
```

This is the package structure:
```
├── src
│    ├── alexandreladriere.imagetoolkit
│    │    ├── utils
│    │    │    ├── Constants.java
│    │    │    ├── FilePathManipulation.java
│    │    │    └── ImageExtensions.java
│    │    └── ImageToolkit.java
```

## License
This project is licensed under the MIT License - see the [LICENSE] file for details.

## Contributing
Contributions are welcome :smile:

### Pull requests
Just a few guidelines:
-   Write clean code with appropriate comments and add suitable error handling.
-   Test the application and make sure no bugs/ issues come up.
-   Open a pull request and I will be happy to acknowledge your contribution after some checking from my side.

### Issues
If you find any bugs/issues, raise an issue.

  [LICENSE]: <LICENSE>
  [ImageToolkit.java]: <src/alexandreladriere/imagetoolkit/ImageToolkit.java>
  [make.sh]: <make.sh>