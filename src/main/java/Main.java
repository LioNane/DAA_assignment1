

void main() {
    String csvFile = "results.csv";

    try {
        List<String> lines = Files.readAllLines(Path.of(csvFile));

        if (lines.isEmpty()) {
            System.out.println("File is empty.");
            return;
        }

        System.out.println("-".repeat(88));

        for (int i = 0; i < lines.size(); i++) {
            String[] columns = lines.get(i).split(",");

            if (columns.length == 6) {
                System.out.printf("| %-15s | %-10s | %-8s | %-10s | %-15s | %-10s |%n",
                        columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
            }

            if (i == 0) {
                System.out.println("-".repeat(88));
            }
        }

        System.out.println("-".repeat(88));

    } catch (IOException e) {
        System.err.println("File reader error: " + e.getMessage());
    }
}