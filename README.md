# SJP Scraper for GoldenDict

This Java tool allows you to scrape meanings from the Słownik Języka Polskiego (SJP) and import them into GoldenDict, a popular dictionary software. This tool provides a seamless way to enhance your GoldenDict with Polish language definitions.

## Prerequisites

Before using this tool, make sure you have the following prerequisites installed:

- **Java 11 or later**: Ensure that you have Java 11 or a later version installed on your machine.

- **Maven**: Make sure you have Maven installed on your machine to compile, package, and install the SjpApi submodule.

- [**GoldenDict**](https://github.com/goldendict/goldendict): Make sure you have GoldenDict installed on your machine. GoldenDict is a feature-rich dictionary lookup program.

## Installation of SjpApi Submodule

1. Navigate to the `SjpApi` submodule directory:

   ```bash
   cd SjpApi/api
   ```

2. Compile and install the SjpApi submodule to the local Maven repository:

   ```bash
   mvn install
   ```

3. Ensure that the SjpApi submodule is successfully installed to the local Maven repository.

## Usage

1. Clone or download this repository to your local machine.

2. Open a terminal and navigate to the project directory.

3. Compile and package the Java application using Maven:

   ```bash
   mvn package
   ```

4. Open GoldenDict.

5. Go to `Edit > Dictionaries`.

6. Click on the `Programs` tab.

7. Add a new entry for the SJP Scraper with the appropriate settings to run the compiled Java application.

    - **Enabled**: True
    - **Type**: HTML
    - **Name**: SJP Scraper
    - **Command line**: `java -jar /path/to/sjp-goldendict-1.0-SNAPSHOT-jar-with-dependencies.jar`

![programs.png](img%2Fprograms.png)

8. Save the configuration.

9. Now, you should see "SJP Scraper" in the list of available dictionaries in GoldenDict.

10. Enter a word in GoldenDict, select "SJP Scraper" from the drop-down menu, and click "Search" to use the scraper.

### Example output

![result.png](img%2Fresult.png)

## Notes

- This tool requires Java 11 or a later version. Ensure that you have an appropriate Java version installed on your system.

- This tool may require an active internet connection to access the SJP website for scraping.

- It's essential to use this tool responsibly and in compliance with the terms and conditions of the SJP website.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to modify and distribute this tool in accordance with the license terms.

## Acknowledgments

Special thanks to the creators of SJP and GoldenDict for providing valuable resources for language enthusiasts and developers.