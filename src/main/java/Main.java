public static int[] merge(int[] left, int[] right){
    int merged_length = left.length + right.length;
    int[] merged = new int[merged_length];

    int left_index = 0;
    int right_index = 0;
    int merged_index = 0;

    while (left_index < left.length && right_index < right.length) {
        if (left[left_index] <= right[right_index]) {
            merged[merged_index] = left[left_index];
            left_index++;
        } else {
            merged[merged_index] = right[right_index];
            right_index++;
        }
        merged_index++;
    }

    while (left_index < left.length){
        merged[merged_index] = left[left_index];
        left_index++;
        merged_index++;
    }

    while (right_index < right.length){
        merged[merged_index] =right[right_index];
        right_index++;
        merged_index++;
    }

    return merged;
}

public static int[] mergeSort(int[] dataset){
    if (dataset.length <= 1) {
        return dataset;
    }

    int left_length = (dataset.length / 2);
    int[] left = new int[left_length];

    for (int i = 0; i < left_length; i++){
        left[i] = dataset[i];
    }

    int right_length = dataset.length - left_length;
    int[] right = new int[right_length];

    for (int i = left_length; i < dataset.length; i++){
        right[i - left_length] = dataset[i];
    }

    left = mergeSort(left);
    right = mergeSort(right);
    return merge(left, right);
}

void main() {

}